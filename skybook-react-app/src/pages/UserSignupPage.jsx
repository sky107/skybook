import React from 'react';

import * as apiCalls from '../api/apiCall'

const actions={
    postSignup:apiCalls.signup
}

class UserSignupPage extends React.Component{
    state={
        displayName:'',
        username:'',
        password:'',
        confirmPassword:''
    }

     onChangeDisplayName=(event)=>{
        const value=event.target.value;
        this.setState({
            ...this.state,
            displayName:value
        })
    }

    onChangeUsername=(event)=>{
        const value=event.target.value;
        this.setState({
            ...this.state,
            username:value
        })
    }

    onChangePassword=(event)=>{
        const value=event.target.value;
        this.setState({
            ...this.state,
            password:value
        })
    }
    onChangeConfirmPassword=(event)=>{
        const value=event.target.value;
        this.setState({
            ...this.state,
            confirmPassword:value
        })
    }

    onClickSignup=async()=>{
        try{

        
    const response=  await  actions.postSignup({
          username:this.state.username,
          displayName:this.state.displayName,
          password:this.state.password
       });
       console.log(response)


       
       if(response.status===200){
            console.log("ok")
       }

    }
    catch(e){
        // console.log(e.response.data);
        // switch(response.data){


        // }
    }

       
     
    }


  

    render() {
        


        return<div className="container">
        <h1 className='text-center'>SignUp</h1>
        <div className="col-12 mb-3">
            <input className="form-control" type="text" placeholder='Your display name' value={this.state.displayName} onChange={this.onChangeDisplayName}/>
            <input className="form-control" type="text" placeholder='Your username' value={this.state.username} onChange={this.onChangeUsername}/>
            <input className='form-control' type="password" placeholder='Your password' value={this.state.password} onChange={this.onChangePassword}/>
            <input className='form-control' type="password" placeholder='Confirm password' value={this.state.confirmPassword} onChange={this.onChangeConfirmPassword}/>
        </div>
            
        <div className='text-center'>
        <button className='btn btn-primary' onClick={this.onClickSignup}>Signup</button>
        </div>
        </div> 
    }
}


export default UserSignupPage;