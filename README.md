# social-coding-android
Discover the magic of making mobile apps!


## Note
# IMPORTANT!  
* If you want to devlop and work on apps, please use
> **Android Studio Iguana** 

## Current Demo of app!
![2024-05-09 10-15-46](https://github.com/Betim-Hodza/Betim-social-coding-android/assets/106614572/ba009f07-6a27-475a-9965-6c330ba8f890)

## How to Contribute 

- To contribute, simply fork this repository and create a new branch for your changes.
- when you want to create a new app within the main app, navigate to the apps folder and create a new kotlin file

Now theres a few steps needed before making changes to the app
- All app function should have this format:
```
@Composable
fun Home(navController: NavHostController) {
}
```
- Its important to note that you need to pass in the navController, that way we can navigate to your app

### Once app has been created
- Head to the Screens file in the app
  - to enable access to your screen, create a new data object with your app name, and the Screens call
```
data object CalculatorApp : Screens("CalculatorApp")
```
- Now Head to the main activity kotlin file
  - at the bottom there is a navhost function call, you can add your composable there
```
composable(Screens.CalculatorApp.screen) { CalculatorApp(navController = navigationController) }
```

- Betim's note: I recommend that you make small changes at a time and make sure you  have tested them before pushing them up. 
This will make sure the app is up and running, without any huge problems!

### Please follow these guidelines when adding content:

1. Make sure your current build doesn't have anything that will crash the app. 
2. When you're finished with a portion of your app, make sure you remove unused imports (will cause memory issues if you keep them)
   * when you are done with your changes just click the build button
3. When making apps, please keep it within the app folder, and create a new folder for your app individually
4. If you need help ask me! (Betim | Baytizzel) or google with these keywords "Jetpack Compose, Kotlin" 
