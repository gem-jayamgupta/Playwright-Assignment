Feature: Fetch data points from PIMCO Income Fund webpage

  Scenario Outline: Extracting details from the PIMCO Income Fund page and storing in Excel
    Given User navigates to "<url>"
    When User selects the first role
    Then User fetches all the data points including date, name, and text
    And User stores the data in an Excel file
    And User validates the data
    Examples:
      | url                                                                            |
      | https://www.pimco.com/us/en/investments/mutual-fund/pimco-income-fund/inst-usd |