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

    onClickSignup=()=>{
        // if(this.props.actions) // to avoid test case failing
        this.props.actions.postSignUp();
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
        <button onClick={this.onClickSignup}>Signup</button>
        </> 
    }
}


export default UserSignupPage;