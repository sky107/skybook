
import React from 'react';
import {render} from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'
import HomePage from './HomePage';
import UserPage from './UserPage';


describe('UserPage',()=>{


    describe('Layout',()=>{

        it('has root page div',()=>{
           const {queryByTestId}= render(<UserPage/>);
           const homePageDiv=queryByTestId('userpage');
           expect(homePageDiv).toBeInTheDocument();

        })
    })

    
})