import React, { Component } from 'react';
import Layout from './components/Layout/Layout';
import FormBuilder from './containers/Forms/mainFormStructure';

class App extends Component {
  render() {
    console.log("App 7",this.props.dispatch)
    return (
      <div>
        <Layout>
          <FormBuilder /> 
        </Layout>
      </div>
    );
  }
}

export default App;
