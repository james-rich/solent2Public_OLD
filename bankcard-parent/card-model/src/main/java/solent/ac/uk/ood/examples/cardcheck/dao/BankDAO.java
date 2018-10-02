/* ***************************************************************************
 * Copyright 2018 Craig Gallen
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
 *
 ****************************************************************************/

package solent.ac.uk.ood.examples.cardcheck.dao;

import java.util.List;
import solent.ac.uk.ood.examples.cardcheck.model.Bank;

public interface BankDAO {

    public Bank getById(Integer id);

    public List<Bank> getAll();

    public Bank add(Bank bank);

    public void delete(Bank bank);

    public void deleteById(Integer id);

    public Bank update(Bank bank);

    public Bank create();
}
