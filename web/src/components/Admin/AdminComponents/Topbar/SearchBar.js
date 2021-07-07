import React from "react";
import classes from "./SearchBar.css";
import SearchIcon from "@material-ui/icons/Search";
import SearchBar from "material-ui-search-bar";

function SearchBarComponent() {
  return (
    <SearchBar 
        cancelOnEscape={true}
        style={{ width: "150px" }} 
    />
    // <div className={classes.search}>
    //    <div className={classes.searchInputs}>
    //        <input className={classes.input} type="text" placeholder="Search" />
    //        <div className={classes.searchIcon}> <SearchIcon /> </div>
    //    </div>
    //    {/* <div className="dataResult"></div> */}
    // </div>
  );
}

export default SearchBarComponent;
