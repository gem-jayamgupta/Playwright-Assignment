Feature: Fetch data points from PIMCO Income Fund webpage

  Scenario Outline: Extracting details from the PIMCO Income Fund page and storing in Excel
    Given User navigates to "<url>"
    When User selects the first role
    Then User fetches all the data points including date, name, and text
    And User stores the data in an Excel file named "<Excel-Name>"
    Examples:
      | url                                                                            | Excel-Name     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/inst-usd | inst-usd-data  |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/a-usd    | a-usd-data     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/c-usd    | c-usd-data     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/i-3-usd  | i-3-usd-data   |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/i-2-usd  | i-2-usd-data   |

  Scenario Outline: Comparing previous and current day details from the PIMCO Income Fund page and store result in excel
    Given User navigates to "<url>"
    When User selects the first role
    Then User fetches all the data points including date, name, and text
    And User stores the data of following day in an Excel file named as "<Excel-Name>"
    And User validates the data in excel "<Excel-Name>"
    Examples:
      | url                                                                            | Excel-Name     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/inst-usd | inst-usd-data  |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/a-usd    | a-usd-data     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/c-usd    | c-usd-data     |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/i-3-usd  | i-3-usd-data   |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/i-2-usd  | i-2-usd-data   |