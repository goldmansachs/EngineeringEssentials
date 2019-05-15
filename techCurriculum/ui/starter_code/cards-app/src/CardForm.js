import React, {Component} from 'react';
import CreatableSelect from 'react-select/lib/Creatable';

export default class CardForm extends Component {

  constructor(props) {
    super(props);
    this.state = { 
      username: "",
      message:"",
      tags:[]
    };

    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.reset = this.reset.bind(this);
    this.handleTags = this.handleTags.bind(this);
  }

  handleChange(event){
    this.setState({[event.target.name]: event.target.value});
  }

  handleTags = (tag, actionMeta) => {
    console.group('Value Changed');
    if(actionMeta.action == "create-option"){
        this.setState(state => {
            state.tags.push(tag)
        })
    }
    else if(actionMeta.action == "remove-value"){
        this.setState(state => {
            state.tags.filter(tag => tag != tag)
        })
    }
    else if(actionMeta.action == "clear"){
        this.setState({tags:[]})
    }
    console.log(`action: ${actionMeta.action}`);
    console.log(actionMeta)
    console.groupEnd();
  };

  handleSubmit(e){
      e.preventDefault();
      if(this.state.username == ""){

      }
      else if(this.state.message == ""){

      }
      else{
        this.props.addCardSuccess(this.state.username,this.state.message,this.state.tags)
        this.reset()
      }
  }

  reset(){
    this.setState({
        username:"",
        message:"",
        tags:[]
    })
  }

  render(){
    return (
      <div>
          <form>
              <input name = "username" value = {this.state.username} type = "text" placeholder="name" onChange={this.handleChange} />
              <input name = "message"  value = {this.state.message} type = "text" placeholder="message" onChange={this.handleChange} />
              <CreatableSelect isMulti isClearable
                onChange = {this.handleTags}
              />
              <button onClick = {this.handleSubmit}> Add </button>
          </form>
      </div>
    );
  }

}

