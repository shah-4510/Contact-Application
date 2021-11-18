The program is build and compiled as Maven Project of SpringBoot in Eclipse.

The user needs to download the zip file and extract into the workspace of Eclipse in their device.

In Eclipse, they can import the project under:
Import -> Existing Maven Project (check that pom.xml is selected while importing)

After that user needs to clean and install the project with the help of :
Right click the project -> Run As -> Maven clean
Right click the project -> Run As -> Maven install
Alt+F5 -> Force Update to remove further errors.

To run the project:
Maven Build -> Goal: spring-boot:run

In browser type localhost:7080 in the address bar.

The user will then see the Home Page.
