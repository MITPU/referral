import React from 'react';
import Input from '../../../UI/Input/Input';

const career = ( props ) => {
return (
    <div>
        <p>{props.name} I am a career link!</p>
        <input 
            type='input' 
            placeholder={props.name} 
            onChange={props.changed} 
            value={props.value} />
    </div>
)}

export default career