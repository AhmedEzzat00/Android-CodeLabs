# Android-Practice-Codelab
A practical app on the android code labs provides by google
This repo contains four apps that represent the four units of the [***Android Developer Fundamentals***](https://developer.android.com/courses/fundamentals-training/overview-v2).

## Content:
### Unit 1:
This unit covers installing Android Studio, understanding project structure, building first blocks, creating activities, testing apps, and using the Android Support Library.
This unit contains three lessons:

*1. Build your first app:* which contains a basic layout that contains a `TextView` and a three `Button`s ,this layout perform a simple counting, when clicking the `Button` the `TextView` increase the count and other `Button` reset the counter to zero.

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lessson%201%20%20screen%20portrait.png" width="200">         <img src=https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lesson%201screen%20landscape.png width="650">

*2. Activities and Intents:* this lesson explain the basic interaction between activities is introduced throw starting the second `Activity` when clicking a button and trying to preserve the UI from the setting configuration change e.g. screen rotation, receiving a call. also experiment with `Intent` by using explicit intent to launch the second activity and implicit intent to share some text, open a location on a map, and opening a website.

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab2_implicitactivity.png" width="200">                                                    <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab2_secondactivity.png" width="200">                                                   <img src=https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab3_mainactivity.png  width="200">

*3. Debugging and Unit Test:* introduce the powerful debugger of android studio and its features, how to set breakpoints, how to evaluate and expression, how to attach the debugger to a process ...etc. Also, introduce the Unit testing techniques using the `JUnit` library and how to set the *test source set* to test the logic of the app.


### Unit 2:
This unit covers how to get input from the user, implement navigation strategies, use themes and styles, test user interface, and follow Material Design principles. Use menus and tabs for navigation, and input controls such as spinners and picker dialogs to get information from the user. How to extract resources to create a style from an instance of a user interface element. 

*4. User interaction:* in this lesson we encounter with the concept of user interaction with the main components of the app how to make use of a clickable image, take input from the user with various ways such as `EditText` to specify the input type for a specific kind of information (eg. phone number, person name,..etc) or `RadioButton` in RadioGroup to select one option from many of the `CheckBox` that can be either selected or none. 

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_orderscreen.png" width="200">

Another thing is the main navigation of the user throw the app using the up key or the back button to get back in the previous activity on the stack, we can also use the menu that can be inflated in the `ActionBar`  specifying which items to add and how to use them we could add a lot of features and preferences such as search, add and remove.

`RecyclerView` is a very important widget to use in android, it replaces the common `ListView` in a very clever way, that depends on loading items that present on the screen and get ready for scrolling with loading the next item in the list, all of that is made with the help of an adapter that knows everything about which item is currently presented and which has the turn to be presents, this widget save a lot of memory and network processing especially when coupled with a third-party library such as `Picasso` or `Glide` that can handle a lot of process on the network while loading images for example. 

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_mainScreen.png" width="200">                                                          <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_datePicker.png" width="200">

*5.Delightful user experience:* In this chapter, we use drawables, which are compiled images that we can be used in our app. Android provides classes and resources to help include rich images in your application with a minimal impact on your app's performance. Apply common styles to views, use drawable resources, and apply themes to the app. These practices reduce code and make the code easier to read and maintain. As an example of applying theme is the use of `Dark_Mode` to provide a low light theme for saving battery and reduce eye tension in the night.

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_scorekeeper.png" width="200"> 

Google's Material Design guidelines are a series of best practices for creating visually appealing and intuitive applications.`CardView` and `FloatingActionButton` widgets are parts of the Material Design they provide a solid pattern to rely on it's behavior, how to use images efficiently.
***Material Design offers the following guidelines for CARDS:***

* A card can be dismissed, usually by swiping it away.
* A list of cards can be reordered by holding down and dragging the cards.
* Tapping on the card provides further details.

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_materialme.png" width="200"> 

Another crucial skill is to know how to make an app that has screen compatibility to the different screen of different devices and different orientation so that the User Experience does not being a disturbance for the growth or shrinking of the screen, finally it to localize app to use different languages for different regions 

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_land.png" width="650">                                                                  <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_spian.png" width="200"> 


