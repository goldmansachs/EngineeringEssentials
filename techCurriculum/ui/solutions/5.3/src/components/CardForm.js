/**
* Copyright 2017 Goldman Sachs.
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
import TextInput from './TextInput.js'
import Select from 'react-select';
import 'react-select/dist/react-select.css';

class CardForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {username: '', message: '', tags: []};
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleUsernameChange = this.handleUsernameChange.bind(this);
    this.handleMessageChange = this.handleMessageChange.bind(this);
    this.handleTagsChange = this.handleTagsChange.bind(this);
  }

  handleUsernameChange(value) {
    this.setState({username: value});
  }

  handleMessageChange(value) {
    this.setState({message: value});
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.onSubmit(this.state.username, this.state.message, this.state.tags);
  }

  handleTagsChange(tagList) {
    const tagValues = tagList.map(tag => tag.value);
    this.setState({tags: tagValues});
  }

  render() {
    const tagOptions = [
      { value: 'today', label: 'Today' },
      { value: 'red', label: 'Red' }
    ];
    return (
      <form className='card-form'>
        <h2>Add a Card</h2>
        <TextInput name='username' label='Username' value={this.state.username} onChange={this.handleUsernameChange}/>
        <TextInput name='message' label='Message' value={this.state.message} onChange={this.handleMessageChange}/>
        <br />
        <Select options={tagOptions} multi value={this.state.tags} onChange={this.handleTagsChange}/>
        <button className='btn btn-primary' onClick={this.handleSubmit}>Submit</button>
      </form>
    );
  }
}

export default CardForm;
