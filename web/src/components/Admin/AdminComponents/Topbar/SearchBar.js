import React from "react";
import SearchBar from "material-ui-search-bar";

function SearchBarComponent() {
  return (
    <SearchBar 
        cancelOnEscape={true}
        style={{ width: "150px" }} 
    />
  );
}

export default SearchBarComponent;
