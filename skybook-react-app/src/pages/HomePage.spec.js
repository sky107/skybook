import React from 'react';
import {render} from '@testing-library/react';
import '@testing-library/jest-dom/extend-expect'
import HomePage from './HomePage';


describe('Homepage',()=>{


    describe('Layout',()=>{

        it('has root page div',()=>{
           const {queryByTestId}= render(<HomePage/>);
           const homePageDiv=queryByTestId('homepage');
           expect(homePageDiv).toBeInTheDocument();

        })
    })

    
})