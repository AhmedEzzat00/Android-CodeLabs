# Android-Practice-Codelab
A practical app on the android code labs provides by google
This repo contains four apps that represent the four units of the [***Android Developer Fundamentals***](https://developer.android.com/courses/fundamentals-training/overview-v2).

## Content:
### Unit 1:
This unit covers installing Android Studio, understanding project structure, building first blocks, creating activities, testing apps, and using the Android Support Library.
This unit contains three lessons:

<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lessson%201%20%20screen%20portrait.png"  width="288" height="512" style="display: inline; float: right"/>

***1. Build your first app:*** which contains a basic layout that contains a `TextView` and a three `Button`s , this layout performs a simple counting, when clicking the `Button` the `TextView` increase the count and other `Button` reset the counter to zero.


***2. Activities and Intents:*** this lesson explain the basic interaction between activities is introduced throw starting the second `Activity` when clicking a button and trying to preserve the UI from the setting configuration change e.g. screen rotation, receiving a call. also experiment with `Intent` by using explicit intent to launch the second activity and implicit intent to share some text, open a location on a map, and opening a website.

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab2_implicitactivity.png" width="200">                                                    <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab2_secondactivity.png" width="200">                                                   <img src=https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab3_mainactivity.png  width="200">

***3. Debugging and Unit Test:*** introduce the powerful debugger of android studio and its features, how to set breakpoints, how to evaluate and expression, how to attach the debugger to a process ...etc. Also, introduce the Unit testing techniques using the `JUnit` library and how to set the *test source set* to test the logic of the app.


### Unit 2:
This unit covers how to get input from the user, implement navigation strategies, use themes and styles, test user interface, and follow Material Design principles. Use menus and tabs for navigation, and input controls such as spinners and picker dialogs to get information from the user. How to extract resources to create a style from an instance of a user interface element. 

<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_orderscreen.png"  width="288" height="512" style="display: inline; float: right"/>

***4. User interaction:*** in this lesson we encounter with the concept of user interaction with the main components of the app how to make use of a clickable image, take input from the user with various ways such as `EditText` to specify the input type for a specific kind of information (eg. phone number, person name,..etc) or `RadioButton` in RadioGroup to select one option from many of the `CheckBox` that can be either selected or none. 


Another thing is the main navigation of the user throw the app using the up key or the back button to get back in the previous activity on the stack, we can also use the menu that can be inflated in the `ActionBar`  specifying which items to add and how to use them we could add a lot of features and preferences such as search, add and remove.

`RecyclerView` is a very important widget to use in android, it replaces the common `ListView` in a very clever way, that depends on loading items that present on the screen and get ready for scrolling with loading the next item in the list, all of that is made with the help of an adapter that knows everything about which item is currently presented and which has the turn to be presents, this widget save a lot of memory and network processing especially when coupled with a third-party library such as `Picasso` or `Glide` that can handle a lot of process on the network while loading images for example. 

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_mainScreen.png" width="200">                                                          <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab4_datePicker.png" width="200">

<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_scorekeeper.png"  width="288" height="512" style="display: inline; float: right"/>

***5.Delightful user experience:*** In this chapter, we use drawables, which are compiled images that we can be used in our app. Android provides classes and resources to help include rich images in your application with a minimal impact on your app's performance. Apply common styles to views, use drawable resources, and apply themes to the app. These practices reduce code and make the code easier to read and maintain. As an example of applying theme is the use of `Dark_Mode` to provide a low light theme for saving battery and reduce eye tension in the night.

Google's Material Design guidelines are a series of best practices for creating visually appealing and intuitive applications.` CardView` and `FloatingActionButton` widgets are parts of the Material Design they provide a solid pattern to rely on its behavior, how to use images efficiently.
***Material Design offers the following guidelines for CARDS:***

* A card can be dismissed, usually by swiping it away.
* A list of cards can be reordered by holding down and dragging the cards.
* Tapping on the card provides further details.

Another crucial skill is to know how to make an app that has screen compatibility to the different screen of different devices and different orientation so that the User Experience does not being a disturbance for the growth or shrinking of the screen, finally it to localize app to use different languages for different regions 

<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_land.png" width="650">                                                                  <img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab5_spian.png" width="200"> 


***6. Testing the UI:*** In the final lesson on this unit we encounter with the concept of testing the mobile app using testing techniques, in here we perform a unit test which is the basis for of testing to use, we use it to test each component of the app working correctly when it interacts with user or getting some sort of input and produce some sort of output.
`Espresso` is a third-party library they provide us with the necessary tools to perform these tests easily,` Espresso` is a testing framework for Android that makes it easy to write reliable UI tests for an app. The framework, which is part of the Android Support Repository, provides APIs for writing UI tests to simulate user interactions within the app—everything from clicking buttons and navigating views to selecting menu items and entering data.

<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab7_search.png"  width="288" height="512" style="display: inline; float: right"/>

### Unit 3:
***7. Background tasks:*** Sometimes an app needs to perform ***resource-intensive tasks*** such as *downloading files*, making database *queries*, *playing media*, or computing complex analytics. This type of intensive work ***can block the UI thread*** so that the app doesn't respond to user input or draw on the screen. Users may get frustrated and uninstall your app.

To keep the user experience (UX) running smoothly, the Android framework provides a helper class called `AsyncTask`, which processes work off of the UI thread. Using `AsyncTask` to move intensive processing onto a separate thread means that the UI thread can stay responsive.
The first part of the lesson describes why we should keep our work outside the UI thread, mainly the UI thread has two rules:
* Don't make operations that **block** the UI
* Do the UI updates in the UI thread
so we use the `AsyncTask` its a `Worker` class that make the work in the background thread it has some flaws in term of Preserving UI Configuration from change so we use `Loader`
The `AsyncTaskLoader` class is part of the Android platform's `Loader` API, which is a framework to manage loading data into your app in the background. Loaders were deprecated in Android P (API 28) in favor of `ViewModels` and `LiveData`.
Preparing `Loader` is as much as the `AsyncTask`, extend the `AsyncTaskLoader<D>`  which D is the result type and implement callback methods in the activity that will handle the loader, then attach the loader with the activity.



The last section of this lesson tells us about a major component of the android system, the `BroadcastReceiver` so as it might seem from its name it has two-part away; *Broadcasts* are messages that the Android system and Android apps send when events occur that might affect the functionality of other apps or app components, for example, the Android system sends a broadcast message when the power is connected or disconnected; A broadcast is received by any app or app component that has a broadcast receiver **registered** for that action.


<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab8_notify.png"  width="288" height="512" style="display: inline; float: right"/>

***8. Alarms and schedulers:*** What should we do when we want to do some tasks when the app is not on the foreground or isn't running? Simple we use `Notification`, A notification is a message that your app displays to the user outside of your app's normal UI. Notifications appear as icons in the device's notification area, which is in the status bar. To see the details of a notification, the user opens the notification drawer, for example by swiping down on the status bar. The notification area and the notification drawer are system-controlled areas that the user can view at any time.

<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab8_notifyupdate.png"  width="288" height="512" style="display: inline; float: right"/>

What if the app needs to take action at a specific time, for example for a calendar notification? In this case, we would use `AlarmManager`. The `AlarmManager` class lets you launch and repeat a `PendingIntent` at a specified time, or after a specified interval.whether or not your app is running when the alarms go off. Alarms can either be single-use or repeating. For example, you can use a repeating alarm to schedule a download every day at the same time.
There are two general types of alarms in Android: elapsed real-time alarms and real-time clock (RTC) alarms, and both use `PendingIntent` objects.
*Elapsed real-time* alarms use the time, in milliseconds, since the device was booted. Time zones don't affect elapsed real-time alarms, so these alarms work well for alarms based on the passage of time. For example, use an elapsed real-time alarm for an alarm that fires every half hour.
*Real-time clock (RTC)* alarms are clock-based alarms that use Coordinated Universal Time (UTC).

In the last part of this lesson we talk about how to organize the flow of operation in a way that maintains the battery life and network usage, Transferring data is an essential part of most Android apps, but it can affect battery life and increase data usage. Using the wireless radio to transfer data is potentially one of your app's most significant sources of battery drain.


Users care about battery drain because they would rather use their mobile devices without it connected to the charger. And users care about data usage because every bit of data transferred can cost them money. Constantly monitoring the connectivity and battery status of the device can be a challenge. It requires using components such as broadcast receivers, which can consume system resources even when your app isn't running. Because transferring data efficiently is such a common task, the Android SDK provides a class that makes efficient data transfer much easier: `JobScheduler`.

Introduced in API level 21, `JobScheduler` allows you to schedule a task around specific conditions, rather than a specific time as with `AlarmManager`.

`JobScheduler` has three components:

* `JobInfo` uses the builder pattern to set the conditions for the task.
* `JobService` is a wrapper around the Service class where the task is actually completed.
* `JobScheduler` schedules and cancels tasks.
Using these combinations of Job classes we can determine what job to run when to run it and at what cost. 

<p align="center">
<img src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/android_workmanager_choice.png" />
</p>

### Unit 4:
***9. Preferences and settings:*** Android provides several options for you to save persistent app data. The solution you choose depends on your specific needs, such as whether the data should be private to your app or access to other apps (and the user) and how much space your data requires. Your data storage options include the following:
<img align="right" src="https://github.com/AhmedEzzat00/Android-CodeLabs/blob/master/screenshots/lab9_sharedpref.png"  width="288" height="512" style="display: inline; float: right"/>
* *Shared preferences*: Store private primitive data in key-value pairs. This is covered in the next chapter.
* *Internal storage*: Store private data on the device memory.
* *External storage*: Store public data on the shared external storage.
* *SQLite databases*: Store structured data in a private database.
* *Room persistence library*: Part of the Android Architecture Component libraries. Room caches an SQLite database locally and automatically syncs changes to a network database
* *Cloud backup*: Back up your app and user data in the cloud.
* *Firebase realtime database*: Store and sync data with a NoSQL cloud database. Data is synced across all clients in real-time and remains available when your app goes offline.
* *Custom data store*: Configure the Preference APIs to store preferences in a storage location you provide.

Shared preferences allow you to store small amounts of primitive data as key/value pairs in a file on the device. To get a handle to a preference file, and to read, write, and manage preference data, use the `SharedPreferences` class. 

The second part of this lesson is app setting, Apps often include settings that allow users to modify app features and behaviors. For example, some apps allow users to specify whether notifications are enabled, or how often the app syncs data with the cloud.

The controls that belong in the app's settings should capture user preferences that affect most users or provide critical support to a minority of users. For example, notification settings affect all users, while a currency setting for a foreign market provides critical support for the users in that market.

Most settings are accessed infrequently because once users change a setting, they rarely need to go back and change it again. If users need to access control or preference frequently, consider moving the control or preference to the app bar options menu, or a side navigation menu such as a navigation drawer.


***10. Storing data with Room:*** SQLite is a software library. SQLite implements an SQL database engine that has the following characteristics:

* Self-contained (requires no other components)
* Serverless (requires no server backend)
* Zero-configuration (does not need to be configured for your app)
* Transactional (changes within a single transaction in SQLite either occur completely or not at all)
* SQLite is the most widely deployed database engine in the world. The source code for SQLite is in the public domain.

So as we see SQLite is a powerful database that we can use in our app to store data and fetch them locally, we can add another layer in the top of it using **Room** library with a combination of **App Component Architecture**, so *what are Android Architecture Components?*

The Android OS manages resources aggressively to perform well on a huge range of devices, and sometimes that makes it challenging to build robust apps. Android Architecture Components guide app architecture, with libraries for common tasks like lifecycle management and data persistence.

Room is a database layer on top of an SQLite database. Room takes care of mundane tasks that you used to handle with an `SQLiteOpenHelper`.

* Room provides compile-time checks of SQLite statements.
* By default, to avoid poor UI performance, Room doesn't allow you to issue database queries on the main thread. LiveData applies this rule by automatically running the query asynchronously on a background thread when needed.
* Usually, we only need one instance of the Room database for the whole app. Make your RoomDatabase a singleton to prevent having multiple instances of the database opened at the same time, which would be a bad thing.
