/**
* Copyright 2018 Goldman Sachs.
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

import React, {Component} from 'react';
import CardForm from './CardForm.js'

class App extends Component {

  constructor(props) {
    super(props);
    this.state = { 
      cards: [],
      currentCard:0 
    };

    this.addCard = this.addCard.bind(this);
  }


  addCard(username,message,tags){
    this.setState((state) => {
      state.cards.push({
        username:username,
        message:message,
        tags:tags
      })
      console.log(state.cards)
      return state
    })
  }



  render(){
    return (
      <div>
        <div className = "left-panel">
          <Title />
          <Card />
        </div>
        <div>
          <CardForm 
            addCardSuccess = {this.addCard}
          />
        </div>
        <div>
          {this.state.cards.map((card,i) => (
            <Card key={i} 
              name = {card.username}
              text = {card.message}
              tags = {card.tags}
            />
          ))}
        </div>
      </div>
    );
  }

}

let Title = (props) => {
  return (
    <div>
      <h1> Cards</h1>
      <h3> Share Your Ideas</h3>
    </div>
  );
}

let User = (props) => {
  return (
    <div className = "user">
      <i className='fa fa-user-o'/>
      <h3 className = "i"> {props.name} </h3>
    </div>
  );
}

let Message = (props) => {
  return (
    <div>
      <p className = "message-text"> {props.text} </p>
    </div>
  );
}

let Card = (props) => {
  return (
    <div className = "card">
      <User name = {props.name}/>
      <Message text = {props.text}/>
      {props.tags.map( (tag,i) => {
        <p key = {i}> {tag} </p>
      })}
    </div>
  );
}

export default App;
