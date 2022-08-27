import React from 'react';
import { render, cleanup, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'
import {jest} from '@jest/globals';
import UserSignupPage from './UserSignupPage';

// we dont' need after v9 of testing
beforeEach(cleanup);

describe('user signup page ', () => {


    describe('layout', () => {


        it('has header of signup', () => {

            const { container } = render(<UserSignupPage />);

            const header = container.querySelector('h1');
            expect(header).toHaveTextContent('SignUp');

        })


        it('has input for dispaly name', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const displayNameInput = queryByPlaceholderText('Your display name')

            expect(displayNameInput).toBeInTheDocument();
        })

        it('has input for username', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const userNameInput = queryByPlaceholderText('Your username')

            expect(userNameInput).toBeInTheDocument();
        })
        it('has input for password', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const passwordInput = queryByPlaceholderText('Your password')

            expect(passwordInput).toBeInTheDocument();
        })

        it('has input for confirm password', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const confirmPasswordInput = queryByPlaceholderText('Confirm password')

            expect(confirmPasswordInput).toBeInTheDocument();
        })

        it('has input for confirm password of passowrd type as text', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const confirmPasswordInput = queryByPlaceholderText('Your password')

            expect(confirmPasswordInput.type).toBe('password')

        })

        it('submit  button', () => {

            const { container } = render(<UserSignupPage />);
            const button = container.querySelector('button');

            expect(button).toBeInTheDocument();
        })


    })




    describe('Interactions', () => {

        const changeEvent = (content) => {
            return {
                target: {
                    value: content
                }
            }
        }

        it('check the typing of display name', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const displayNameInput = queryByPlaceholderText('Your display name')

            // const changeEvent = {
            //     target: {
            //         value: 'my-display-name'
            //     }
            // };

            fireEvent.change(displayNameInput, changeEvent('my-display-name'));
            expect(displayNameInput).toHaveValue('my-display-name');
            //but we want to test it usign states




        })

        it('check the typing of username', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const displayUsernameInput = queryByPlaceholderText('Your username')

            // const changeEvent = {
            //     target: {
            //         value: 'my-display-name'
            //     }
            // };

            fireEvent.change(displayUsernameInput, changeEvent('my-display-name'));
            expect(displayUsernameInput).toHaveValue('my-display-name');
            //but we want to test it usign states




        })
        it('check the typing of password', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const passwordInput = queryByPlaceholderText('Your password')

            // const changeEvent = {
            //     target: {
            //         value: 'my-display-name'
            //     }
            // };

            fireEvent.change(passwordInput, changeEvent('my-test-password'));
            expect(passwordInput).toHaveValue('my-test-password');
            //but we want to test it usign states




        })

        it('check the typing of password', () => {
            const { queryByPlaceholderText } = render(<UserSignupPage />);
            const confirmPasswordInput = queryByPlaceholderText('Confirm password')

            // const changeEvent = {
            //     target: {
            //         value: 'my-display-name'
            //     }
            // };

            //but we want to test it usign states


            fireEvent.change(confirmPasswordInput, changeEvent('my-test-password'));
            expect(confirmPasswordInput).toHaveValue('my-test-password');




        })


        // actions ka kuch lafda hai
        // it('calls backend when fields are valid', () => {
            

        //     const actions = {
        //         // mocking api call
        //         // this name should be same as in component
        //         postSignUp: jest.fn().mockResolvedValueOnce({})
        //     }
        //     const { container, queryByPlaceholderText } = render(<UserSignupPage actions={actions} />);

        //     const displayNameInput = queryByPlaceholderText('Your display name')
        //     const displayUsernameInput = queryByPlaceholderText('Your username')
        //     const passwordInput = queryByPlaceholderText('Your password')
        //     const confirmPasswordInput = queryByPlaceholderText('Confirm password')



        //     fireEvent.change(displayNameInput, changeEvent('my-display-name'));
        //     fireEvent.change(displayUsernameInput, changeEvent('my-display-username'));
        //     fireEvent.change(passwordInput, changeEvent('my-test-password'));
        //     fireEvent.change(confirmPasswordInput, changeEvent('my-test-password'));

        //     const button = container.querySelector('button');
        //     fireEvent.click(button);
        //     expect(actions.postSignUp).toHaveBeenCalledTimes(1);
        // });
        // semicolon important syntaz error elese



    //    

});

});






