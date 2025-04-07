---
layout: page
title: John Doe's Project Portfolio Page
---

## Project: TutorSynch

Below are my project contributions:

***
### Codebase:
* Feature 1: Added `Current Grade` field to student's information
  * Allows tutor to store the current grade of the student and keep track of student's progress
  * Tested functionality of feature with empty inputs and duplicate `cg/` fields
* Feature 2: Added Colour Coded Visuals to `Current Grade` field in student's information
  * Allows tutor to differentiate grade levels to see how student is progressing
* Feature 3: Added Light Theme to Application's GUI
  * Allows tutor to customize and change themes if certain texts are hard to read 
  * Tested visibility of different text colours in the different themes to ensure readability
***
### Documentation:
* User Guide:
  * Refurbished details of adding `Current Grade` field in `add` command
  * Added details regarding `Current Grade` field
  * Added details regarding switching of themes feature
* Developer Guide:
  * Created additional Non-Functional Requirements for project
  * Created Use Case for `find`, `filter`, `help`, `toggletheme` and `exit` commands
  * Formatted Use Cases for standardization
* README:
  * Refurbished design of README to incorporate relevant features of TutorSynch
***
### Bug Fixing:
* Line 64 of EditCommand.java – Closes Issue #207
  * Fixed in MESSAGE_USAGE 
* Line 14 and 15 of Tag.java - Closes Issue #229
  * Added in MESSAGE_CONSTRAINTS and updated UG’s features section, `add` and `edit` commands sections to not allow spaces in tag names 
* Line 14,15 and 21 of Name.java – Closes Issue #243
  * Added in MESSAGE_CONSTRAINTS, fixed Validation Regex to include ‘,’ , ‘’’ and ‘/’ symbols and updated UG in the Features Section
* Line 12, 18, 25, 26 and 34 of Email.java – Closes #227, #245, #251, #256, #258, #277
  * Updated Max_Length to 254, added in MESSAGE_CONSTRAINTS to not allow consecutive special characters in local and domain part, fixed Validation Regex to check for at least 1 ‘.’ in domain name and updated UG in Features Section
