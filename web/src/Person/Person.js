// Let's create a component
// We don't need a component cuz here we are not using a class which extends component
// instead we are creating a function
import React from 'react'
import './Person.css'

const person = (props) => {
    return (
        <div className="Person">
            <p onClick={props.click}>I am {props.name} and I am {props.age} years old!</p>
            <p>{props.children}</p>
            <input type="text" onChange={props.changed} />
        </div>
    )
}

export default person;