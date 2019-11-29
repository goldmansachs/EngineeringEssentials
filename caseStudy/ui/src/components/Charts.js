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
import LineChart from './charts/LineChart';
//import JohnData from './components/data/john_posts.json';

class Charts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {


            /**
             * TODO
             * Initialize a state object to store a JavaScript object returned from the helper method.
             * It can be initialized to be empty.
             */
        };
    }


    componentWillMount(nextProps) {
        console.log("Calling helper method to fetch data from service.");
        this.dataSourceHelper(nextProps);
    }

    dataSourceHelper(props) {
        props = props || this.props;

        /**
         * TODO
         * Write a helper method to make an AJAX HTTP request to your service for the
         * company and dates specified in a props parameter. You can use promises(axios),
         * fetch, jQuery...there are many libraries to help you do this. The data you will
         * receive will be in a JSON format.
         * https://hashnode.com/post/5-best-libraries-for-making-ajax-calls-in-react-cis8x5f7k0jl7th53z68s41k1
         * fetch: https://davidwalsh.name/fetch
         * axios: https://github.com/mzabriskie/axios (you will need to install this package)
         * jquery: http://api.jquery.com/jquery.getjson/ (you will need to install the jquery package)
         *
         * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
         * your service is running. Your service MUST be running for the request to work (you can add a catch function
         * to handle errors). Once you make the request, you will want to convert the JSON to a JavaScript
         * object and set in the component state so it can be passed as a prop to your LineChart component.
         *
         * REMEMBER, you'll need to use '=>' if you want to set the state in a callback or promise due
         * to the scope of the 'this' object.
         *
         * Data received should be in a JSON format of
         * {
         *      "dailyClosePrices": [
         *      {
         *         "3/15/2018": 284.97,
         *          "4/6/2018": 152.97,
         *          "4/21/2018": 156.97,
         *          ...
         *      }],
         *      "name": "SOME_STOCK_NAME"
         *  }
         *
         *  Do you need to enable CORS for your service??
         *  https://spring.io/guides/gs/rest-service-cors/#_enabling_cors
         *
         *  Don't forget to bind the helper method in the constructor!
         * */
    }

    render() {

        return (
            <div>
                <LineChart />
            </div>
        )
        /**
         * TODO
         * Render your LineChart component and pass the data for the chart to display via props
         */
    }
}

export default Charts;