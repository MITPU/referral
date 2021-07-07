import React from 'react';
import styled from 'styled-components';
import NavLink from './NavLink';

const LinksGroup = styled.div`
    display: flex;
    flex-direction: column;
    padding: 24px 0 14px 0;
    overflow: hidden;
    overflow-y: auto;

    ::-webkit-scrollbar {
        width: 5px;
    }

    /* Track */
    ::-webkit-scrollbar-track {
        background: transparent;
    }

    /* Handle */
    ::-webkit-scrollbar-thumb {
        background: rgba(255,255,255, 0.4);
        border-radius: 4px;
    }

    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
        background: #555;
    }
`

// const DenseNavLinks = styled(NavLink)`
//     box-shadow: none;
//     min-height: 36px;
// `

function NavLinksGroup() {
    return (
        <LinksGroup>
            <NavLink to="/" iconClassName="fas fa-box" label="Participant Form"/>
            <NavLink to="/" iconClassName="fas fa-box" label="Referrer Form"/>
            <NavLink to="/" iconClassName="fas fa-box" label="Admin"/>
        </LinksGroup>
    );
}

export default NavLinksGroup;