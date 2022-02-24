import { React, useState } from 'react';
import { GoogleLogin } from 'react-google-login';

export const LoginCard = () => {
    const [loginData, setLoginData] = useState(
        localStorage.getItem('loggedInUser')
            ? JSON.parse(localStorage.getItem('loggedInUser'))
            : null
    );

    const [securedData, setSecuredData] = useState("")

    const handleFailure = (failure) => {
        console.log(failure);
    };

    const handleLogin = async (googleData) => {
        console.log(googleData);
        const name = (googleData.profileObj.name);
        setLoginData(name);
        localStorage.setItem("loggedInUser", JSON.stringify(name));

        const response = await fetch('http://localhost:8080/secured', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${googleData.tokenId}`,
              }
        });

        const securedData = await response.text();
        setSecuredData(securedData);
    };

    const handleLogout = () => {
        localStorage.removeItem('loggedInUser');
        setLoginData(null);
    };

    return (
        <div className="LoginCard">
            {loginData ? (
                <div>
                    <h3>You logged in as {loginData}</h3>
                    <button onClick={handleLogout}>Logout</button>
                </div>
            ) : (
                <GoogleLogin
                    clientId={process.env.REACT_APP_GOOGLE_CLIENT_ID}
                    buttonText="Log in with Google"
                    onSuccess={handleLogin}
                    onFailure={handleFailure}
                    cookiePolicy={'single_host_origin'}
                />
            )}
            <p>{securedData}</p>
        </div>
    );
}