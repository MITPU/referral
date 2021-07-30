import React, { Component } from 'react';
import Layout from './hoc/Layout/Layout';
import FormBuilder from './containers/Forms/mainFormStructure';
import 'bootstrap/dist/css/bootstrap.min.css';

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
