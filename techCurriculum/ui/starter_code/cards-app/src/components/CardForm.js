import React from 'react';
import TextInput from './TextInput.js'

class CardForm extends React.Component {
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(event) {

  }

  render() {
    return (
      <form className='card-form'>
        <h2>Add a Card</h2>
        <TextInput name='username' label='Username' />
        <TextInput name='message' label='Message' />
        <button className='btn btn-primary' onClick={this.handleSubmit}>Submit</button>
      </form>
    );
  }
}
export default CardForm;
