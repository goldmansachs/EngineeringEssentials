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
 */

import React from 'react';
import './style/App.css';
import Date from './components/Date.js';
import StockTicker from "./components/StockTicker";
import LineChart from './components/charts/LineChart';
import Charts from './components/Charts';
import JohnData from './components/data/john_posts.json';
/**
 * TODO:
 * Import your components
 */


class App extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            /**
             * TODO
             * Add state objects for the user inputs and anything else you may need to render the highchart.
             */
        };

    }





    render () {
      return (
          <div className="page-display">

              <div className="input">
                  {/**
                   * TODO
                   * Render the StockTicker and Date components. You can use the date component twice
                   * for both the start and end dates.
                   * Add onChange props to the StockTicker and both Date components.
                   * These props methods should set state and help determine if the
                   * highchart should be displayed by changing the state of that boolean.
                   * Don't forget to bind these methods!
                   */}

                  <StockTicker />



                <Charts  />
                <LineChart dataOne={JohnData.data}  />

                  <div className="date-range">
                      <Date text="Start Date"/>
                      <Date text="End Date"/>
                  </div>
              </div>


              {/**
               *  TODO
               *  Create a div element that shows a highchart when the ticker, start date, end date
               *  states ALL have values and nothing (null) otherwise. You will need to use a conditional here
               *  to help control rendering and pass these states as props to the component. This conditional can
               *  be maintained as a state object.
               *  http://reactpatterns.com/#conditional-rendering
               */}



          </div>
      );
    }
}

export default App;
