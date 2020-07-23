import React, { Component } from 'react';
import Layout from './components/Layout/Layout';
import FormBuilder from './containers/Forms/mainFormStructure';

class App extends Component {
  render() {
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
