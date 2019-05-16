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
 * TODO
 Create a highcharts line chart of your choosing (e.g. https://www.highcharts.com/demo/line-time-series for a demo).
 */

import React from 'react';
import Highcharts from 'highcharts';

class LineChart extends React.Component {
    constructor(props) {
        super(props);
        this.highchartsOptions = {
            title: {
                text: 'Goldman Sachs'

            },
            xAxis: {
                title: {
                    text: 'Dollars'
                },
                categories: ['2/16/2019','3/15/2019', '4/6/2019', '4/17/2019','5/1/2019']
            },
            yAxis: {
                title: {
                    text: 'Dollars'
                }
            },
            series: [{
                name: 'Goldman Sachs',
                marker: {
                    symbol: 'square'
                },
                data: props.dataOne

            }]
            /*, {
              name: 'Jane Doe',
              marker: {
                symbol: 'diamond'
              },
              data: props.dataTwo
            }]
            */
        }
    }

    componentDidMount() {

        Highcharts.chart('chart', this.highchartsOptions);



        /*
        Highcharts.chart('chart', {



            series: [{
                name: 'Prices',
                data: this.props.data
            }]
        });
*/
    }

    componentWillReceiveProps(props) {
        console.log("New data received to redraw chart.");

        /**
         * TODO
         * Parse the data received from props, a Javascript object, to map to a Javascript array
         * required by the type of line chart chosen and set it in the series. Use Date.UTC(..)
         * to create the x-axis.
         */

        /**
         * TODO
         * Uncomment the line below to pass the data be displayed to the series
         * this.chart.series[0].setData(data);
         */
    }

    componentWillUnmount() {
        this.chart.destroy();
    }


    render() {
        return (
            <div id='chart'></div>
        )
    }
}

export default LineChart;