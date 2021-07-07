import React from 'react';
import MenuIcon from '@material-ui/icons/Menu';
import styled from 'styled-components';
import SearchBar from '../../components/Admin/AdminComponents/Topbar/SearchBar';

const Grid = styled.div`
    display: grid;
    grid-template-columns: min-content 1fr min-content;
    height: 48px;
    align-items: stretch;
    padding: 0 24px;
    
    background-color:  rgb(251, 251, 255);
    > div {
        display: flex;
        align-items: center;
    }
    
    span {
        display: grid;
        justify-content: end;
        align-items: center;
    }
    // &:first-child {
    //     div {
    //         display: none;
    //         @media(max-width: 900px) {
    //             display: inline;
    //         }
    //     }
    // }
`

function Header({toggle}) {
    return (
        <Grid>
            <div onClick={toggle}>
                <MenuIcon />
            </div>
            <span><SearchBar /></span>
        </Grid>
    )
}

export default Header;