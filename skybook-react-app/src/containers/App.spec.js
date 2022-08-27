import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import { MemoryRouter } from 'react-router-dom';


const setup = (path) => {
    return render(<MemoryRouter initialEntries={[path]}>
        <App />
    </MemoryRouter>)
}


describe('App', () => {

    it('it displays homepage when url is /', () => {
        const { queryByTestId } = setup("/");
        expect(queryByTestId('homepage')).toBeInTheDocument();
    })

    it('it displays LoginPage when url is /login', () => {
        const { container } = setup("/login");
        const header=container.querySelector('h1');
        expect(header).toHaveTextContent('Login');
    })
    
    it('it displays LoginPage when url is /register', () => {
        const { container } = setup("/register");
        const header=container.querySelector('h1');
        expect(header).toHaveTextContent('SignUp');
    })


})