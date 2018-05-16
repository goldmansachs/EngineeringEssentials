import React from 'react'

function Title(props){
    return(<div>
        <h1>{props.company}</h1>
        <h3>Industry: {props.industry}</h3>

    </div>);
};

export default Title