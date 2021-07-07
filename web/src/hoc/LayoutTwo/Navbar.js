import React from 'react';
import styled from 'styled-components';
import logo from '../../components/assets/images/logo.png';
import Backdrop from './Backdrop';
import NavLinksGroup from './NavLinksGroup';

const StyledNav = styled.nav`
    width: 250px;
    position: sticky;
    top: 0;
    z-index: 1;
    background-color: #0c5b95;
    height: 100vh;
    width: 250px;
    display: flex;
    flex-direction: column;

    &::before {
        content: "";
        position: absolute;
        width: 100%;
        height: 100%;
        z-index: -1;
    }
    @media (max-width: 900px) {
        position: fixed;
        transform: translate3d(${p => p.visible ? 0 : "-260px"}, 0, 0);
        transition: transform .3s ${p => p.visible ? "cubic-bezier(0.4, 0, 1, 1)" : "cubic-bezier(0, 0, 0.2, 1) !important"};
    }
`

const StyleImg = styled.img`
    background-color: #0c5b95;
    margin: 10px;
    width: 90%;
`

function Navbar(props) {
    return (
        <React.Fragment>
            <Backdrop visible={props.visible} onClick={props.close}/>
            <StyledNav {...props}>
                <StyleImg src={logo} alt='Logo' />
                <NavLinksGroup />
            </StyledNav>
        </React.Fragment>
    )
}

export default Navbar;