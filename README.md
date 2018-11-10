# ChristmasTreePi
## Pi4J based project to control Christmas Tree controlled by Raspberry Pi

The following project is focused for educators that teach high school / college age programmers.  It gives students the ability to see the code they develop can actually manipulate the physical world.  There are also some key concepts valuable for teaching:

* *Abstraction using Interfaces and Abstract classes*: The Java program allows you to control either the physical christmas tree or a "virtual" christmas tree.  It allows students to take the program home and use their virtual tree to tweak their programs and bring it back to class to see how it works on a physical tree using abstraction.  It doesn't currently use the Factory Pattern, but that can easily be adopted as well.

* *Frameworks*: The build apparatus uses Spring and Gradle to compile and build the final Java project together into a single jar (found at build/libs/ChristmasTree.jar).  It is "Springboot" based to bundle all libraries into a single master library, but because it's self contained, it's not a true SpringBoot project.  You can modify so it does.


### WARNING
While a lot of Pi projects involve low voltage breadboard based projects that at worst will give a student a minor shock, this project deals with live 110 - 115 volt charges that could be lethal.  Take precautions to safeguard the students from careless behavior.  Suggestions are:

* *Physical Locks* - When the box is plugged in and running, keep the box locked with a combination or key lock so students cannot tamper with.  If you can't monitor the box at all times while in a classroom, keep it locked.

* *Unplug while displaying to class* - If you want to show to students how the box works, unplug it from the wall.  DON'T just turn off the power strip.  It is easy to "accidentally" turn the strip on and electrocute someone.  Remember to shutdown your pi BEFORE unplugging if possible.

* *Troubleshoot at home* - If a wire comes undone or something isn't working properly, don't be tempted to triage the issue in class with students.  Ensure you are alone where careless behavior won't result in an accident.

---

### YouTube / Credit Links
* *[BytesOfPi Channel](https://www.youtube.com/channel/UCxwh7SU2e4nbOYQR8SYe2VQ)*: This project is brought to you by BytesOfPi educational channel.  Feel free to dig into Christmas Tree playlist for more detail on the building of the project as well as other projects and APCS related materials.

* *[Instructables Raspberry Pi Christmas Tree Light Show](https://instructables.com/id/Raspberry-Pi-Christmas-Tree-Light-Show/)*: Osprey22 provided the initial inspiration for the project with this How-To DIY video for Raspberry Pi and Christmas tree light show.

* *[Dee Higginbotham](https://www.youtube.com/playlist?list=PLQMY6gaXDkJdLYoUv5l2Pzrd8vcrbtCgU)*:
   I drew most of the design ideas and inspiration from this gentleman who put together this DIY list of videos.  The goals of our projects are different as his is for personal yard use while this project is focused on portability and programming.

   1. Arduino vs Pi: The main difference in project design is Dee uses a windows computer attached to Arduino devices.  This project uses a Standalone Raspberry Pi as the driver.  Because the Raspberry Pi 3 is a computer with WiFi capabilities, controlling the device remotely is easier.
   
   2. Vixen vs programming: Dee's focus is home use, so he uses precanned programs like Vixen and Falcon Player to drive the light coordination.  While you could do the same for this project (probably... haven't tested it out yet), the focus is on student development of Java / Python programs to drive the control

---

Placeholder for Project Setup

Placeholder for anecdotes