1. Copy the jar in a new folder inside your project called 'libs'
2. Modify the build.gradle:
        dependencies {
            compile files('libs/GoogleAdMobAdsSdk-6.4.1.jar')
        }
3./gradlew assemble 
in the project folder
4.Modify AndroidManifest.xml, add permissions:
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
5.Add in the Manifest this Activity:
        <activity android:name="com.google.ads.AdActivity" android:configChanges="keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize"></activity>
6.Ignore the cannot resolve error, android studio does not seem to like ads, until you restart the IDE.
