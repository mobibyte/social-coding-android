# Contributing

## Development environment setup

To set up a development environment, please follow these steps:
1. Download Android Studio for your PC:
   - ChromeOS/Linux: (android-studio-2023.2.1.25-cros.deb (944.2 MB))[https://redirector.gvt1.com/edgedl/android/studio/install/2023.2.1.25/android-studio-2023.2.1.25-cros.deb] 
   - Mac (Apple Silicon): (android-studio-2023.2.1.25-mac_arm.dmg (1.2 GB))[https://redirector.gvt1.com/edgedl/android/studio/install/2023.2.1.25/android-studio-2023.2.1.25-mac_arm.dmg]
   - Mac (Intel): (android-studio-2023.2.1.25-mac.dmg (1.2 GB))[https://redirector.gvt1.com/edgedl/android/studio/install/2023.2.1.25/android-studio-2023.2.1.25-mac.dmg]
   - Windows (64-bit): (android-studio-2023.2.1.25-windows.exe (1.1 GB)) [https://redirector.gvt1.com/edgedl/android/studio/install/2023.2.1.25/android-studio-2023.2.1.25-windows.exe]


2. Fork the repo

3. Open the app

   To open the app properly, make sure you open the app in this file path: 
   ``` social-coding-android/App ```

4. Head to (How to Contribute) on this page

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

1. Make sure your current build doesn't have anything that will crash the app. (IMPORTANT)
2. When you're finished with a portion of your app, make sure you remove unused imports (will cause memory issues if you keep them)
   * when you are done with your changes just click the build button
3. When making apps, please keep it within the app folder, and create a new folder for your app individually
4. If you need help ask me! (Betim | Baytizzel) or google with these keywords "Jetpack Compose, Kotlin" 


## Issues and feature requests

You've found a bug in the source code, a mistake in the documentation or maybe you'd like a new feature? You can help us by [submitting an issue on GitHub](https://github.com/mobibyte/social-coding-android/issues). Before you create an issue, make sure to search the issue archive -- your issue may have already been addressed!

Please try to create bug reports that are:

- _Reproducible._ Include steps to reproduce the problem.
- _Specific._ Include as much detail as possible: which version, what environment, etc.
- _Unique._ Do not duplicate existing opened issues.
- _Scoped to a Single Bug._ One bug per report.

**Even better: Submit a pull request with a fix or new feature!**

### How to submit a Pull Request

1. Search our repository for open or closed
   [Pull Requests](https://github.com/mobibyte/social-coding-android/pulls)
   that relate to your submission. You don't want to duplicate effort.
2. Fork the project
3. Create your feature branch (`git checkout -b feat/amazing_feature`)
4. Commit your changes (`git commit -m 'feat: add amazing_feature'`) SocialCodingAndroid uses [conventional commits](https://www.conventionalcommits.org), so please follow the specification in your commit messages.
5. Push to the branch (`git push origin feat/amazing_feature`)
6. [Open a Pull Request](https://github.com/mobibyte/social-coding-android/compare?expand=1)
