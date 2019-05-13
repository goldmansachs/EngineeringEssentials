/**
* Copyright 2019 Goldman Sachs.
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
**/

import React from 'react';
import User from './User';
import Message from './Message';

const Card = (props) => {
  const tagElements = props.tags.map((tag, index) =>
    <div key={index} className='badge badge-pill' id='tag'>
      {tag.value}
    </div>
  )
  return (
    <div className='card'>
      <User name={props.author}/>
      <div className='card-main'>
        <Message text={props.text}/>
      </div>
      {tagElements}
    </div>
  );
}

export default Card;
