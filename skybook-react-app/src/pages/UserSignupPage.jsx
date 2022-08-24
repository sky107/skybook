import React from 'react';



class UserSignupPage extends React.Component{

    state={
        displayName:'',
    }

     onChangeDisplayName=(event)=>{
        const value=event.target.value;
        this.setState({
            ...this.state,
            displayName:value
        })

    }



    render() {
        


        return<>
        <h1>Sign Up</h1>
        <div>
            <input type="text" placeholder='Your display name' value={this.state.displayName} onChange={this.onChangeDisplayName}/>
            <input type="text" placeholder='Your username'/>
            <input type="password" placeholder='Your password'/>
            <input type="password" placeholder='Confirm password'/>
        </div>
        <button>Signup</button>
        </> 
    }
}


export default UserSignupPage;