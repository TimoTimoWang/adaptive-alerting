/*
 * Copyright 2018-2019 Expedia Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expedia.adaptivealerting.anomdetect.forecast.interval.algo;

import com.expedia.adaptivealerting.anomdetect.AlgoParams;
import lombok.Data;
import lombok.experimental.Accessors;

import static com.expedia.adaptivealerting.anomdetect.util.AssertUtil.isTrue;

@Data
@Accessors(chain = true)
public final class MultiplicativeIntervalForecasterParams implements AlgoParams {

    /**
     * Multiplier against the level, used to generate the weak interval:
     * [pointForecast - weakMultiplier * level, pointForecast + weakMultiplier * level].
     */
    private double weakMultiplier;

    /**
     * Multiplier against the level, used to generate the strong interval:
     * [pointForecast - strongMultiplier * level, pointForecast + strongMultiplier * level].
     */
    private double strongMultiplier;

    @Override
    public void validate() {
        isTrue(weakMultiplier >= 0.0, "Required: weakMultiplier >= 0.0");
        isTrue(strongMultiplier >= weakMultiplier, "Required: strongMultiplier >= weakMultiplier");
    }
}
