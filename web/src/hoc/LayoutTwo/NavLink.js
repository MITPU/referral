import React from 'react';
import styled from 'styled-components';
import { NavLink as Link } from 'react-router-dom';

const StyledLink = styled(Link)`
    min-height: 56px;
    display: flex;
    align-items: center;
    padding: 0 24px;
    font-size: 12px;
    font-weight: 500;
    color: rgba(255,255,255,.7);
    box-shadow: 0 -1px 0 0 rgba(255,255,255, .1);
    i {
        min-height: 22px;
        min-width: 22px;
        font-size: 18px;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
    }
    span {
        padding-left: 14px;

    }
    &:hover {
        text-decoration: none;
        background-color: rgba(255 255 255 / 5%);
    }
`

function NavLink({children, iconClassName, label, ...rest}) {
    return (
        <StyledLink to="/products" {...rest}>
            {children || (
                <React.Fragment>
                    <i className={iconClassName} />
                    <span className="label">{label}</span>
                </React.Fragment>
            )} 
        </StyledLink>
    )
}

export default NavLink;