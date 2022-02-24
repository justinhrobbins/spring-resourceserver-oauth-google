# spring-resourceserver-oauth-google

# Background
This repo is intended to recreate the issue described in this StackOverlow question: [How to configure Spring Boot + OAuth2 + Resource Server to work with Google's multiple values for issuer URI?](https://stackoverflow.com/questions/71245108/how-to-configure-spring-boot-oauth2-resource-server-to-work-with-googles-mu)

Also relevant is this StackOverflow question: [Spring Boot Authorization Server + Google OAuth2/OpenId Connect should work with access_token or id_token?](https://stackoverflow.com/questions/71254326/spring-boot-authorization-server-google-oauth2-openid-connect-should-work-with)

# Setup
- Set Google Client Id and Secret properties in Spring Boot's `application.properties` with appropriate values for your environment
- Set Google Client Id in React's `.env` file with appropriate values for your environment
- Run `npm install` in the `ui` folder

# Start the App
- Start Spring Boot app
- Start React by running `npm start` in `ui` folder

# Test it out > Make it fail
- Open Chrome browser to http://localhost:3000/ <- running of `npm start` likely already opened your browser for you
- Open Chrome developer tools
- Click "Login with Google" button in browser to login to Google
- Login should succeed but subsequent GET request to the Resource Server for secured @Controller will fail with a 401 (as seen in the Chrome developer tools console)
- Spring Boot log will show stack trace and error: `An error occurred while attempting to decode the Jwt: The iss claim is not valid`

# Test it out > Make it succeed
- Uncomment Bean override for `JwtDecoder` in `SpringResourceserverOauthGoogleApplication`
- Restart Spring Boot
- Open the browser app and click the button to re-login to Google
- Login should suceed and this time the secured request will succeed and you should see no error in the browser console and "This is a response from a SECURED resource" written to the web page
