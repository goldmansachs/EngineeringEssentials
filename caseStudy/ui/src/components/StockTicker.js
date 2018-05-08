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
 */




/* Display a stock ticker that provides typeahead (aka autocomplete) capability.
 * This requires making an AJAX HTTP request (asynchronous JavaScript and XML request) to
 * your service and prefetching the list of all available stock tickers or making an async
 * query every time the input changes (AsyncTypeahead). If you don't have a route defined
 * in your services/API that returns all stock tickers as a JSON object, create one!
 *
 * You can use promises(axios),
 * fetch, jQuery...there are many libraries to help you do this. The data you will
 * receive will be in a JSON format.
 * https://hashnode.com/post/5-best-libraries-for-making-ajax-calls-in-react-cis8x5f7k0jl7th53z68s41k1
 * fetch: https://davidwalsh.name/fetch
 * axios: https://github.com/mzabriskie/axios (you will need to install this package)
 * jquery: http://api.jquery.com/jquery.getjson/ (you will need to install the jquery package)
 *
 * Feel free to choose among of the many open source options for your typeahead select box.
 * We recommend react-select or react-bootstrap-typeahead. react-boostrap-typeahead is included
 * in your package.json.
 *
 * react-select:
 * https://www.npmjs.com/package/react-select
 * http://jedwatson.github.io/react-select/
 * https://github.com/JedWatson/react-select
 * 
 * react-boostrap-typeahead
 * https://www.npmjs.com/package/react-bootstrap-typeahead
 * http://ericgio.github.io/react-bootstrap-typeahead/
 * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/example/examples/BasicBehaviorsExample.react.js (note this is not ES2015)
 */

import React from 'react';
//import {Typeahead} from 'react-bootstrap-typeahead'; UNCOMMENT this line if you are using the react-bootstrap-typeeahead component

/* If you chose to use react-boostrap-typeahead, look at AsyncTypeahead for a component that 
 * provides auto-complete suggestions as you type. This would require adding a search handler 
 * method for an onSearch prop.
 * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/example/examples/AsyncExample.react.js
 */

class StockTicker extends React.Component {

    /**
     * TODO
     * Prefetch the data required to display options fo the typeahead component. Initialize a state array with
     * this data and pass it via props to the typeahead component that will be rendered.
     * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Data.md
     * e.g.
     * options : [
     *   GS,
     *   AAPL,
     *   FB,
     * ]
     * If you are having difficulty with this, you may hard code the options array from the company data provided for the
     * services.
     */
    constructor(props) {
        super(props);
        this.state = {
            showcompanyinfo: false, //TODO: Use this boolean to determine if the company information should be rendered
            company : {
                symbol: '',
                name: '',
                city: '',
                state: '',
                sector: '',
                industry: ''
            }
            /**
             * TODO
             * Add any additional state to pass via props to the typeahead component.
             */
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        if (event.length > 0) {
            /**
             * TODO
             * Make a request to your service to GET company information for the selected company and set it in state.
             * The information you will need to determine the URL will be contained in the 'event[0]' object,
             * e.g. event[0] (event[0].symbol if your options are an array of objects) provides you the symbol selected.
             * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
             * your service is running. Your service MUST be running for the request to work (you can add a catch function
             * to handle errors). If you successfully retrieve this information, you can set the state objects
             * and render it.
             */
            this.setState({showinfo: true});

            //this.props.onChange(..);  Call this.props.onChange with the selected symbol to propagate it
            // to the App component, which will handle it via its own onChane prop,
            // ultimately  used to fetch the data for the LineChart component.

        }
        else {
            this.setState({showinfo: false});
            this.props.onChange(undefined);
        }
    }


    render() {

        /**
         * TODO
         * Render a typeahead component that uses the data prefetched from your service to display a list of companies or
         * ticker symbols. The props you use can be stored as state objects.
         * On change should fetch the company information and display Company, Ticker Symbol, City, State/Country, Sector, and Industry information.
         * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Props.md
         */

        return (
            <div className="stockticker">
                <div className="ticker-input">
                    <p><strong>Stock Ticker</strong></p>
                    <div className="stockticker-typeahead">
                        {/* useful props if you decide to use react-bootstrap-typeahead
                        <Typeahead
                             align=
                             filterBy=
                             labelKey=
                             onChange={this.handleChange}
                             minLength=
                             placeholder="Company Name/Ticker"
                             options=
                        />
                        */}
                    </div>
                </div>
                {
                    /**
                     *  TODO
                     *  Create a div element that shows a company information when the ticker changes. You will need to use a conditional here
                     *  to help control rendering and pass these states as props to the component. This conditional can
                     *  be maintained as a state object.
                     *  http://reactpatterns.com/#conditional-rendering
                     */
                }
            </div>
        );
    }

}

//Don't forget to export your component!