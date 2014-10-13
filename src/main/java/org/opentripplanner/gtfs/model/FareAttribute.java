/* This program is free software: you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public License
 as published by the Free Software Foundation, either version 3 of
 the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>. */

package org.opentripplanner.gtfs.model;

import java.io.IOException;

public class FareAttribute extends Entity {

    public String fare_id;
    public String price;
    public String currency_type;
    public String payment_method;
    public String transfers;
    public String transfer_duration;

    @Override
    public String getKey() {
        return fare_id;
    }

    public static class Factory extends Entity.Factory<FareAttribute> {

        public Factory() {
            tableName = "fare_attributes";
            requiredColumns = new String[] {"fare_id"};
        }

        @Override
        public FareAttribute fromCsv() throws IOException {
            FareAttribute fa = new FareAttribute();
            fa.fare_id        = getStringField("fare_id");
            fa.price          = getStringField("price");
            fa.currency_type  = getStringField("currency_type");
            fa.payment_method = getStringField("payment_method");
            fa.transfers      = getStringField("transfers");
            fa.transfer_duration = getStringField("transfer_duration");
            return fa;
        }

    }

}