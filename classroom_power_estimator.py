"""
 Classroom Power Consumption Estimator
"""

from tabulate import tabulate
import matplotlib.pyplot as plt

def main():
    print(" Classroom Power Consumption Estimator ")

    num_devices = int(input("Enter the number of devices in the classroom: "))

    devices = []

    for i in range(num_devices):
        print(f"\nDevice {i+1}:")
        name = input("Device name: ")
        power = float(input("Power rating (in watts): "))
        hours = float(input("Usage per day (in hours): "))

        daily_kwh = (power * hours) / 1000
        monthly_kwh = daily_kwh * 30

        devices.append({
            'name': name,
            'power': power,
            'hours': hours,
            'daily_kwh': daily_kwh,
            'monthly_kwh': monthly_kwh
        })

    # Create table
    table = []
    total_daily = 0
    total_monthly = 0

    for d in devices:
        table.append([
            d['name'],
            f"{d['power']} W",
            f"{d['hours']} hrs/day",
            f"{d['daily_kwh']:.2f} kWh/day",
            f"{d['monthly_kwh']:.2f} kWh/month"
        ])
        total_daily += d['daily_kwh']
        total_monthly += d['monthly_kwh']

    print("\n Classroom Power Consumption Estimate:")
    headers = ["Device", "Power", "Usage", "Daily Consumption", "Monthly Consumption"]
    print(tabulate(table, headers, tablefmt="grid"))

    print(f"\n Total Daily Consumption: {total_daily:.2f} kWh")
    print(f" Total Monthly Consumption: {total_monthly:.2f} kWh")

    # Plot bar chart
    device_names = [d['name'] for d in devices]
    daily_consumptions = [d['daily_kwh'] for d in devices]

    plt.figure(figsize=(8,5))
    plt.bar(device_names, daily_consumptions, color='lightblue')
    plt.title("Daily Energy Consumption by Device")
    plt.ylabel("Energy (kWh)")
    plt.xlabel("Device")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    main(