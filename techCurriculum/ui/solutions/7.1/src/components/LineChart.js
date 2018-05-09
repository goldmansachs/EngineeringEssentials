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
**/

import React from 'react';
import Highcharts from 'highcharts';

class LineChart extends React.Component {
  constructor(props) {
    super(props);
    this.highchartsOptions = {
      title: {
        text: 'Posts Per Month'
      },
      xAxis: {
        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
          'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
      },
      yAxis: {
        title: {
          text: 'Number of Posts'
        }
      },
      series: [{
        name: 'John Smith',
        marker: {
          symbol: 'square'
        },
        data: props.dataOne

      }, {
        name: 'Jane Doe',
        marker: {
          symbol: 'diamond'
        },
        data: props.dataTwo
      }]
    }
  }

  componentDidMount() {
    Highcharts.chart('chart', this.highchartsOptions);
  }

  render() {
    return <div id='chart'></div>
  }
}

export default LineChart;
