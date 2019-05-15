import React from 'react';
import User from './User.js';
import Message from './Message.js';

const Card = (props) => {
  return (
    <div className='card'>
      <User name = {props.author}/>
      <div className='card-main'>
        <Message text = {props.text}/>
      </div>
    </div>
  );
}
export default Card;