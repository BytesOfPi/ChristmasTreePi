#!/usr/bin/env python
#
# Command Line usage:
#   runMusic.py <input sequence> <audio file>
# Thanks to https://www.instructables.com/id/Raspberry-Pi-Christmas-Tree-Light-Show/

import RPi.GPIO as GPIO, time
import sys
import time
import pygame
import random

#This is the array that stores the SPI sequence
set = bytearray(25 * 3)

# Defines the mapping of logical mapping to physical mapping
# 1 - 7 are lights from top to bottom on tree
# 8 = Multi colored covering tree
# pin_map = [0,11,12,8,15,16,18,22,7]

logical_map = [0 for i in range(9)]
# Defines the mapping of the GPIO1-8 to the pin on the Pi
pin_map = [3,5,7,8,10,11,12,13]


# Setup the board
GPIO.setmode(GPIO.BOARD)
for i in range(0,8):
  GPIO.setup(pin_map[i], GPIO.OUT)
time.sleep(2.0);


# Open the input sequnce file and read/parse it
with open(sys.argv[1],'r') as f:
  seq_data = f.readlines()
  for i in range(len(seq_data)):
    seq_data[i] = seq_data[i].rstrip()

# Current light states
lights = [False for i in range(8)]

# Load and play the music
pygame.mixer.init()
pygame.mixer.music.load(seq_data[0])
pygame.mixer.music.play()

# Start sequencing
start_time = int(round(time.time()*1000))
step       = 2 #ignore the first 2 header lines 
while True :
  # Get next instruction line and split up on colons 
  next_step = seq_data[step].split(":");
  turn_on = next_step[1].rstrip().split(",");
  turn_off = next_step[2].rstrip().split(",");
  cur_time = int(round(time.time()*1000)) - start_time

  # time to run the command
  if int(next_step[0]) <= cur_time:

    print (next_step)

    # Loop through turn on/off channels
    for cmd in turn_on:
      if cmd:
        GPIO.output(pin_map[int(cmd)-1],True)

    for cmd in turn_off:
      if cmd:
        GPIO.output(pin_map[int(cmd)-1],False)

    # If you've reached the last command, break out of loop
    if step >= len(seq_data):
      for i in range(1,9):
        GPIO.output(pin_map[logical_map[i]],False)
      break

    # Otherwise, go to next command
    step += 1

  # ------END-Program---------------------------------

GPIO.cleanup()
print("Test Complete")
