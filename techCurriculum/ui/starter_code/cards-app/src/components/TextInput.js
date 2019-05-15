import React from 'react';

class TextInput extends React.Component {
  constructor(props) {
    super(props);
    this.state = { value: '' };
  }

  render() {
    return (
      <div className='form-group'>
        <label className='control-label'>{this.props.label}</label>
        <input type='text' className='form-control' name={this.props.name} value={this.state.value} />
      </div>
    )
  }
}

export default TextInput;
