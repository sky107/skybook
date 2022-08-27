import React from 'react';

import {Router,Route,Switch,Redirect} from 'react-router-dom';

import HomePage from '../pages/HomePage';
import LoginPage from '../pages/LoginPage';
import UserSignupPage from '../pages/UserSignupPage';


export default function App(){
    return <div>
        <div className='container'>
            <Switch>
            <Route exact path="/" component={HomePage}/>
            <Route exact path="/login" component={LoginPage}/>
            <Route exact path="/register" component={UserSignupPage} />
            </Switch>
        </div>
    </div>
}