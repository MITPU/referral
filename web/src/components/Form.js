import React, { Component } from 'react'

class Form extends Component {
    constructor(props) {
        super(props)
        this.state = {
            name: '',
            comments: '',
            choosing: 'Student'
        }
    }
    handleUsernameChange = event => {
        this.setState({
            name: event.target.value
        })
    }
    handleCommentsChange = event => {
        this.setState({
            comments: event.target.value
        })
    }
    handleTopicChange= event => {
        this.setState({
            choosing: event.target.value
        })
    }
    handleSubmit = event => {
        alert(`${this.state.name} ${this.state.comments} ${this.state.choosing}`)
        event.preventDefault()
    }
    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div>
                    <label>Name</label>
                    <input 
                    type='text' 
                    value={this.state.name} 
                    onChange={this.handleUsernameChange}/>
                </div>
                <div>
                    <label>Comments</label>
                    <textarea  
                    value={this.state.comments} 
                    onChange={this.handleCommentsChange}>
                    </textarea>
                </div>
                <div>
                    <label>Choose Yourself</label>
                    <select value={this.state.choosing} onChange={this.handleTopicChange}>
                        <option value="Student">Student</option>
                        <option value="Referrer">Referrer</option>
                        <option value="Admin">Admin</option>
                    </select>
                </div>
                <button class="btn btn-primary" type="Submit">Submit</button>
            </form>
        )
    }
}

export default Form