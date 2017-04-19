# OpenBankProjectPOC for Android
This is a proof of concept application for logging into and interacting with banks and accounts from the Open Bank Project PSD2 Sandbox.

To test the application you first need to visit the [Open Bank Project PSD2 website](https://apisandbox.openbankproject.com/index). Here you can register yourself and get an API key.

Now create some accounts on the OBP PSD2 webpage, associated with whichever banks you choose.

Next check out this project and create a file called `oauth.properties` in the root of this project and add your consumer key as follows: `consumer_key="your consumer key"`. Don't forget the quote marks.

Now run the app and enter your credentials. **Important** This app is using [direct login](https://github.com/OpenBankProject/OBP-API/wiki/Direct-Login) until OAuth can be added.

You should see the list of banks available in the sandbox. Clicking a bank will give you the number of accounts owned by your user at that FI.  

That's all there is for the moment but next up this project will first provide more account details and eventually facilitate transfers between accounts. See the issues tab for more details.
