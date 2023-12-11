### Status of newly implemented features:
- Dither an image implementation: Y
- Script command to dither an image: Y
- Dither an image from GUI: Y

### Changelog:
We implemented dithering to be in harmony with the existing functional design pattern being followed by our code providers. We made the following changes to achieve this:

- Model
  - Image operation:
    - In the current functional design pattern, each image operation has its own class and group of similar operations have a shared interface. 
    - Considering this, we created a new class "DitherEffect" that implements "ImageTransformer" in the "model.imagetransformer" package, which contains the logic for the dither operation.
  - Adding feature to application:
    - We added a new wrapper method "ditherImage(String srcKey, String dstKey)" in the existing "Model" interface to expose this feature.
    - Implemented this new method in the "ModelImp" class.
- Controller:
  - Created a new command class "DitherCommand" that implements "CommandsInterface" to support dithering.
  - Script support:
    - Added this new command to the command map in the "MapCommands" class.
  - GUI support:
    - Added a new method in the "Feature" interface to expose dithering to the UI.
    - Implemented this new method in the "GUIController" class.
- View:
  - Added a new button "Dither Image" in the existing GUI view.
  - Added a case in the existing "actionPerformed" method in this view to invoke the controller when the dither button is clicked.

### HOW TO USE THE PROGRAM:
To run the program through the jar file go to the directory where the jar file is present (res folder). Open the command prompt and then you can use any of the following mentioned command to run the program. 
  - java -jar Assignment7.jar -> This will run the program and open the GUI view of the program. This provides an interactive interface to the user where the user can load the image and perform various operations on the image. The user can also save the image by selecting a paticular file location. 
  - java -jar Assignment7.jar -text -> This will run the program in an interactive text mode, allowing the user to type the script and execute it one line at a time. The list of the commands supported can be found in the USEME file. Any other command will result in throwing an error stating that the input command is invalid. 
  - java -jar Assignment7.jar -file path-of-script-file -> This will run the program and execute the script file and then shut it down. If the path doesn't exists it shows the appropriate error message. Note that the path of the script file should be relative to the jar file. 
  - Any other command passed will result in program not running showing that the command line arguements inputted are invalid.


### Citations for Resources used.
- The File Image.png its corresponding formats are created and owned by the authors of this program.
- All Images used for testing and representation purposes are owned by the developers of this project by direct ownership.